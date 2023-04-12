package com.Bob_R.loosely;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Balance {
    private UUID userId;
}
