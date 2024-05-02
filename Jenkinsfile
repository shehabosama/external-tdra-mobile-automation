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

 stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: 'master', url: 'https://github.com/shehabosama/external-tdra-mobile-automation.git'
            }
        }
          stage('Upload') {
                    steps {
                        browserstackAppUploader('D:\\busniss\\ext-app-android\\app\\releaseQA\\releaseQA-9.6.0.apk') {
                           echo "${env.BROWSERSTACK_APP_ID}"
                            writeFile file: 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\ext-tdra-automation-pipeline\\browserstackID.txt', text: "${env.BROWSERSTACK_APP_ID}"
                          }
                    }
                }
 stage('Compile and update browserstack File') {
            steps {
                // Use Gradle to build the APK
                //  cd C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\automation_ci_cd
                script {
                    bat '''
                mvn compile
            '''
                }

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