package org.apache.storm.jms.spout;

import java.io.Serializable;

/**
 * Created by tgoetz on 7/14/14.
 */
public class JmsMessageID implements Comparable<JmsMessageID>, Serializable {

    private String jmsID;

    private Long sequence;

    public JmsMessageID(long sequence, String jmsID){
        this.jmsID = jmsID;
        this.sequence = sequence;
    }

    @Override
    public int compareTo(JmsMessageID jmsMessageID) {
        return (int)(this.sequence - jmsMessageID.sequence);
    }

    @Override
    public int hashCode() {
        return this.sequence.hashCode();
    }

    @Override
    public String toString() {
        return this.jmsID;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof JmsMessageID){
            JmsMessageID id = (JmsMessageID)o;
            return this.jmsID.equals(id.jmsID);
        } else {
            return false;
        }
    }

}
