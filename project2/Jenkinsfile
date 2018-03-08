pipeline {
    agent any
    tools {
        maven '3.5.3'
    }
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello, Build'
                sh 'mvn --version'
            }
        }
        stage('Example Test') {
            steps {
                echo 'Hello, Test'
            }
        }
    }
}
