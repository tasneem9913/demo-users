package com.user.configuration;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UserFieldSetMapper implements FieldSetMapper<Users> {
    @Override
    public Users mapFieldSet(FieldSet fieldSet) throws BindException {
        return new Users(fieldSet.readInt("id"),
                fieldSet.readString("name"));
    }
}
