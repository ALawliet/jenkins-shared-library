package providers

import common.DNS.AWS

class AWS {
    AWS() {

    }

    def AWS_DNS DNS() {
        return new AWS_DNS()
    }
}