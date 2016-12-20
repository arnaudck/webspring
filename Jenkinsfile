stage "Test"
node {
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]) {
		sh 'cd webspring && mvn clean verify'
		junit '**/target/surefire-reports/*.xml'
	}
}

stage "Deploy"
node {
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]) {
		sh 'cd webspring && mvn clean tomcat7:deploy -Pprod -DskipTests'
	}
}
