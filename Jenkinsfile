pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Maven\\apache-maven-3.9.8'
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git 'https://github.com/MartinIlg12/ApiIntegracion.git'
            }
        }

        stage('Construir proyecto') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Desplegar en servidor') {
            steps {
                bat '''
                IF EXIST C:\\Servidor\\Spring\\app.jar del /f /q C:\\Servidor\\Spring\\app.jar
                copy target\\*.jar C:\\Servidor\\Spring\\app.jar
                '''
            }
        }

        stage('Ejecutar aplicación') {
            steps {
                bat 'java -jar C:\\Servidor\\Spring\\app.jar'
            }
        }
    }
}
