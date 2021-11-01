package com.personal.productservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class GenerateDBSequence {
    @Autowired
    private MongoOperations mongoOperations;
    @Transient
    public static final String SEQUENCE_NAME = "sequence_counter";

    public long getNextSquence(){
        CustomSequences counter = mongoOperations.findAndModify(query(where("_id").is(SEQUENCE_NAME)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);
        return counter.getSeq();
    }
    @Document(collection = "customSequences")
    public class CustomSequences{
        @Id
        private String id;
        private long seq;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }
    }
}
