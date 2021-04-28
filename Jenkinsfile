pipeline {
	environment {
    		def APP_NAME = "api-testing-poc-master"
    		def GIT_REPO_NAME = "ShitalG100"
    		def DEPLOY_ENV = "dev"
	}
    	agent any
    	stages {
		stage('Code Checkout') {
			steps {
				sh "if [ -d ${api-testing-poc-master} ]; then rm -rf ${api-testing-poc-master}; fi"
				sh "git clone https://github.com/${ShitalG100}/${api-testing-poc-master}.git"
			}
		}
		stage('Azure Cloud Connect'){
			steps {
				sh "az login --identity"
				sh "az account set --subscription xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
				sh "az aks get-credentials --resource-group atos-tra-pla-rg --name atos-tra-pla-cluster"			
			}
		}
		stage('Build & Image'){
			steps {
				sh "az acr build -r tntaksreg -t ${api-testing-poc-master} ."			
			}
		}
		stage('Deploy'){
			steps {
				sh "kubectl delete deployment ${api-testing-poc-master}-deployment --namespace=${dev}"
				sh "kubectl apply -f ${dev}.yml --namespace=${dev}"
			}
		}
    	}
	post { 
		success { 
		    echo "Your application URL will be - http://${api-testing-poc-master}.e46708b92c054086909b.eastus.aksapp.io"
		}
		failure { 
		    echo "Please check logs for more details."
		}
    	}
}
