package com.bob.readbpmnfile.Read_File_BPMNFile.entity;

public class BPMNFile {
    private BPMNFile bpmnFile;
    private String bpmn20Xml;

    public BPMNFile getBpmnFile() {
        return bpmnFile;
    }

    public void setBpmnFile(BPMNFile bpmnFile) {
        this.bpmnFile = bpmnFile;
    }

    public String getBpmn20Xml() {
        return bpmn20Xml;
    }

    public void setBpmn20Xml(String bpmn20Xml) {
        this.bpmn20Xml = bpmn20Xml;
    }
}
