package providers

import common.DNS.AWS.AWS_DNS

class AWS {
    def context
    def config

    AWS(pipelineContext, Map providerConfig) {
        println 'AWS constructor'
        this.context = pipelineContext
        this.providerConfig = providerConfig
    }

    def AWS_DNS DNS() {
        return new AWS_DNS(this.context)
    }
}