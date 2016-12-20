node {
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]) {
		sh 'cd webspring && mvn verify'
	}
}

