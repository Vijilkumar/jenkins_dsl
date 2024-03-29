job("data2") {
        description("This is a sample job2 running from file system")
        keepDependencies(false)
        parameters {
                stringParam("data1", "server", "This is a valid input")
        stringParam("data2", "server", "This is a valid input")
        validatingStringParameterDefinition {name 'REV1'
                                        regex '^[0-9a-f]+$'
                                        defaultValue ''
                                        failedValidationMessage ''
                                             description ''}
        }
        disabled(false)
        concurrentBuild(true)
        steps {
		shell("""echo "triggering from the machine"
sh /var/lib/jenkins/workspace/data2/testshell.sh""")
	}
}
