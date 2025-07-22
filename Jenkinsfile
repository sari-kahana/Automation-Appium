pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17'  // גרסת Maven ו-JDK שתבחרי
            args '-v $HOME/.m2:/root/.m2'   // מונט קאש של Maven (אופציונלי)
        }
    }

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/sari-kahana/Automation-Appium.git', description: 'Repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
    }

    environment {
        MAIN_BRANCH = 'main'
    }

    triggers {
        cron('30 5 * * 1') // כל שני ב-05:30
    }

    stages {
        stage('Checkout Code') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "🔄 Starting checkout stage"
                    script {
                        if (params.BRANCH_NAME == MAIN_BRANCH) {
                            checkout scm
                        } else {
                            git branch: "${params.BRANCH_NAME}", url: "${params.REPO_URL}"
                        }
                    }
                    echo "✅ Checkout stage completed successfully"
                }
            }
        }

        stage('Compile') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "🔧 Starting compilation stage"
                    sh 'mvn compile'
                    echo "✅ Compilation stage completed successfully"
                }
            }
        }

        stage('Run Tests') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    echo "🧪 Starting test stage"
                    sh 'mvn test'
                    echo "✅ Test stage completed successfully"
                }
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check the logs."
        }
    }
}
