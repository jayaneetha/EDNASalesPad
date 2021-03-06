package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class DealerImage {

    private String DocumentId;
    private String File;
    private String DealerId;


    public DealerImage() {
    }

    public DealerImage(String documentId, String file, String dealerId) {
        this.DocumentId = documentId;
        this.File = file;
        this.DealerId = dealerId;
    }


    public String getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(String documentId) {
        DocumentId = documentId;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    public String getDealerId() {
        return DealerId;
    }

    public void setDealerId(String dealerId) {
        DealerId = dealerId;
    }
}
