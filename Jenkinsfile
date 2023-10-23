pipeline {
    agent any
    tools { 
        jdk 'JDK11'
        maven 'Maven 3.9.2' 
    }
//     environment {
//         DEPLOYMENT_TIMESTAMP = "${currentBuild.getTimeInMillis()}"
//     }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('build') {
            steps {
                echo 'Build demo jenkins automatically - here is mvn again'
                sh 'mvn --version'
                dir('/root/.jenkins/workspace/Jenkins_Demo_main') {
                     sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('copy') {
                    steps {
                        script {
                             //def deploymentPath = "/usr/local/etc/jenkinsdemo"
                             def sourcePath = "/root/.jenkins/workspace/Jenkins_Demo_main"
                             def deploymentPath = "/usr/local/share/jenkinsdemodepl"
                             def jarFilename = "jenkinsdemo-0.0.1-SNAPSHOT.jar"
                             sh "cp ${sourcePath}/target/${jarFilename} ${deploymentPath}"
                        }
                    }
        }
        stage('execute') {
                            steps {
                                script {
                                    //stop jenkinsdemo services
                                    sh "systemctl stop jenkinsdemo"
                                    //start jenkinsdemo services
                                    sh "systemctl start jenkinsdemo"
                                    //enable jenkinsdemo services
                                    sh "systemctl enable jenkinsdemo"
                                }
                            }
        }

    }
    post {
            success {
                // Archive build artifacts only for the main branch
                when {
                    expression { currentBuild.changeSets[0].branch == 'origin/main' }
                }
                archiveArtifacts allowEmptyArchive: true, artifacts: '**/*'
            }
        }

}
