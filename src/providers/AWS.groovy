package providers

import common.DNS.AWS.AWS_DNS

class AWS {
    def context

    AWS(pipelineContext) {
        println 'AWS constructor'
        this.context = pipelineContext
    }

    def AWS_DNS DNS() {
        return new AWS_DNS(this.context)
    }
}