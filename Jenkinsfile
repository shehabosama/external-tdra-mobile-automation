pipeline {
    agent any
 tools {
        jdk 'JAVA_HOME'
        // Specify the JDK tool installation by name and version
        maven 'MAVEN_HOME'
    }
    stages {
           stage('setup') {
         steps {
          browserstack('ae398edf-2122-477e-9d2b-999e76291acc') {
              echo 'success'

          }
             browserStackReportPublisher 'automate'
         }
      }
      stage('Upload') {
            steps {
                browserstackAppUploader('D:\\jenkins_test_ci_cd\\app\\release\\app-release.apk') {
                  echo "${env.BROWSERSTACK_APP_ID}"
}
            }
        }
 stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: 'master', url: 'https://github.com/shehabosama/external-tdra-mobile-automation.git'
            }
        }

        stage('Build') {
            steps {
                // Use Gradle to build the APK
                //  cd C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\automation_ci_cd
                script {
                    bat '''
                mvn test
            '''
                }

            }

        }


    }
     post {
        always {
            // Publish HTML report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/surefire-reports',
                reportFiles: 'index.html',
                reportName: 'Automation HTML Report'
            ])
        }
         success {
            script {
                archiveArtifacts artifacts: '**/index.html', allowEmptyArchive: true
            }
        }
    }

}