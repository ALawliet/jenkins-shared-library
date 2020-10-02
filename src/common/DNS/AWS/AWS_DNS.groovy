package common.DNS.AWS

import common.DNS.DNSInterface
import groovy.json.JsonOutput

class AWS_DNS implements DNSInterface {
    def context

    AWS_DNS(pipelineContext) {
        this.context = pipelineContext
        println 'AWS_DNS constructor'
    }

    def String getResourceConfigAsJSON(Map resourceConfig) {
        String json = JsonOutput.prettyPrint(JsonOutput.toJson(resourceConfig))
        return json
    }

    def Map addRecord(Map resourceConfig) {
        println 'add DNS record with AWS'
        println 'cat ./../../../resources/myscript'.execute().text
        return resourceConfig
    }

    def String getThing() {
        return 'some thing'
    }

    def String readScript() {
        // String fileContents = new File('../../../../resources/myscript').text
        String fileContents = this.context.libraryResource('myscript')
        return fileContents
    }

    def void executeTerraform() {
        def terraformscript = this.context.libraryResource './terraform/main.tf'
        this.context.writeFile file: './terraform/main.tf', text: terraformscript
        this.context.dir('./terraform') {
            this.context.sh 'terraform init'
            this.context.sh 'terraform validate'
            this.context.sh 'terraform plan'
        }
    }

    def void executeTerraform2() {
        def terraformscript = this.context.libraryResource './terraform/main.tf'
        this.context.writeFile file: './terraform/main.tf', text: terraformscript
        this.context.dir('./terraform') {
            this.context.sh 'terraform init'
            this.context.sh 'terraform validate'
            def task = 'terraform plan'.execute()
            task.waitFor()
            println task.text
        }
    }
}