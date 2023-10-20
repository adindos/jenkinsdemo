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
//                 dir('/Users/faizal/.jenkins/workspace/jenkinsdemo_main') {
//                      sh 'mvn clean package -DskipTests'
//                 }
            }
        }

    }

}
