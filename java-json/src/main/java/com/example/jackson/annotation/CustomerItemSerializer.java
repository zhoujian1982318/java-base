package com.example.jackson.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomerItemSerializer extends StdSerializer<CustomerItem> {

    public CustomerItemSerializer(){
        this(null);
    }

    public CustomerItemSerializer(Class<CustomerItem> t) {
        super(t);
    }

    @Override
    public void serialize(CustomerItem value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("itemName", value.getItemName());
        gen.writeNumberField("owner", value.getOwner().getId());
        gen.writeEndObject();
    }
}
