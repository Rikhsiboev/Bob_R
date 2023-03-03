package Bob_r;

import lombok.Getter;

@Getter
public enum Gender {

    FEMALE("female"),MALE("male");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
