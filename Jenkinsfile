pipeline {
    agent any
    stages {
        stage('从github上拉取代码') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/xjxiaopeng/ruoyi-vue-pro.git']])
            }
        }
        stage('编译代码') {
            steps {
               sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('将编译好的jar包上传到服务器') {
            steps {
               sshPublisher(publishers: [sshPublisherDesc(configName: '43.154.82.233', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'cd /work/projects/lab-41-demo01', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/work/projects/lab-41-demo01/build', remoteDirectorySDF: false, removePrefix: 'yudao-server/target/', sourceFiles: 'yudao-server/target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }

    }

}
