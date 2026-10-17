pipeline {
    agent any

    environment {
        PATH+TOOLS = '/opt/homebrew/bin:/opt/homebrew/opt/openjdk@21/bin'
        JAVA_HOME = '/opt/homebrew/opt/openjdk@21'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub'
                checkout scm
            }
        }

        stage('Verify Tools') {
            steps {
                sh 'which java'
                sh 'java -version'
                sh 'which mvn'
                sh 'mvn -version'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Application') {
            steps {
                sh 'java -cp target/classes com.example.App'
            }
        }
    }

    post {
        success {
            echo 'CI Pipeline completed successfully!'
        }
        failure {
            echo 'CI Pipeline failed. Check the console output.'
        }
    }
}
