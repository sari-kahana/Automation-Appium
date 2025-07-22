pipeline {
    agent any

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/sari-kahana/Automation-Appium.git', description: 'Repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
    }

    environment {
        MAIN_BRANCH = 'main'
    }

    triggers {
        cron('30 5 * * 1') // כל שני בשעה 05:30
        cron('0 14 * * *') // כל יום בשעה 14:00
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo "Starting checkout stage"
                script {
                    if (params.BRANCH_NAME == MAIN_BRANCH) {
                        checkout scm
                    } else {
                        git branch: "${params.BRANCH_NAME}", url: "${params.REPO_URL}"
                    }
                }
                echo "Checkout stage completed successfully"
            }
            timeout(time: 5, unit: 'MINUTES')
        }

        stage('Compile') {
            steps {
                echo "Starting compilation stage"
                sh 'mvn compile'
                echo "Compilation stage completed successfully"
            }
            timeout(time: 5, unit: 'MINUTES')
        }

        stage('Run Tests') {
            steps {
                echo "Starting test stage"
                sh 'mvn test'
                echo "Test stage completed successfully"
            }
            timeout(time: 5, unit: 'MINUTES')
        }
    }

    post {
        success {
            echo "Pipeline completed successfully ✅"
        }
        failure {
            echo "Pipeline failed ❌"
        }
    }
}
