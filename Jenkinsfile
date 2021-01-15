pipeline{
    agent any
    stages{
        stage ("run gradle") {
          steps {
            echo 'executing gradle...'
            withGradle(){
              sh './gradlew clean test'
            }
          }
        }

        stage ('Cucumber Reports') {
              steps {
                    cucumber buildStatus:'UNSTABLE',
                    fileIncludePattern:'**/cucumber.json',
                    jsonReportDirectory:'target'

              }
        }

    }
}
