package com.devteria.identity.dto.response;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileCreationResponse {
    String id;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
