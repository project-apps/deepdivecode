package com.app.service;

import java.io.IOException;

import com.app.entity.dto.PincodeDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class PincodeDeserializer extends StdDeserializer<PincodeDto> {

	private static final long serialVersionUID = -6280424028867588790L;

	public PincodeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public PincodeDto deserialize(JsonParser parser, DeserializationContext deserializer)
			throws IOException, JsonProcessingException {
		PincodeDto pincode =  new PincodeDto();
		while(!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();
			if(JsonToken.FIELD_NAME.equals(jsonToken)) {
				String fieldName = parser.getCurrentName();
				//System.out.println(fieldName);
				
				jsonToken = parser.nextToken();
				if("pincode".equals(fieldName)){
                    pincode.setPincode(parser.getValueAsString());
                } else if ("Related Suboffice".equals(fieldName)){
                	pincode.setRelatedSuboffice(parser.getValueAsString());
                }
			}
		}
		return pincode;
	}

}
