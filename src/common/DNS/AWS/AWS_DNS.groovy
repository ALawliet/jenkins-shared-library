package common.DNS.AWS

import common.DNS.DNSInterface

class AWS_DNS implements DNSInterface {
    AWS_DNS() {
        
    }

    def void addRecord() {
        println ('add DNS record with AWS')
        println 'cat /../../../resources/myscript'.execute().text
    }
}