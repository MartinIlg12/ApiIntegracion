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

        stage('Ejecutar aplicación') {
            steps {
                bat '''
                cd target
                java -jar crud-conexion-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }
}
