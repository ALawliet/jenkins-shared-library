package providers

import common.DNS.AWS.AWS_DNS

class AWS {
    AWS() {
        println 'AWS constructor'
    }

    def AWS_DNS DNS() {
        return new AWS_DNS()
    }
}