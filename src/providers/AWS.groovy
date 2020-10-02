package providers

import common.DNS.AWS.AWS_DNS

class AWS {
    def context
    def config

    AWS(pipelineContext, Map config) {
        println 'AWS constructor'
        this.context = pipelineContext
        this.config = config
    }

    def AWS_DNS DNS() {
        return new AWS_DNS(this.context)
    }
}