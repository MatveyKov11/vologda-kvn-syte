package com.kvn_syte.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    Long id;

    Long user_id;
    String action;
    Long object_id;
    String object_type;
}
