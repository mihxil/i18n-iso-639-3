package org.meeuw.test.i18n.languages;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.meeuw.i18n.languages.LanguageCode;

@SuppressWarnings("OptionalGetWithoutIsPresent")
class LanguageCodeTest {
    
    @Test
    public void stream() {
        LanguageCode.stream().forEach(lc -> {
            System.out.println(lc);
            assertThat(lc.getCode()).isNotNull();
            assertThat(lc.getLanguageType()).isNotNull();
            assertThat(lc.getScope()).isNotNull();


            if (lc.getComment() != null) {
                System.out.println("Comment: " + lc.getComment());
            }
        });
    }
    
    @Test
    public void getByCode() {
        assertThat(LanguageCode.getByCode("nld").get().getRefName()).isEqualTo("Dutch");
        assertThat(LanguageCode.getByCode(null)).isEmpty();
    }
    
    @Test
    public void get2() {
        assertThat(LanguageCode.get("nl").get().getRefName()).isEqualTo("Dutch");
        assertThat(LanguageCode.get("nld").get().getRefName()).isEqualTo("Dutch");
    }
    
    @Test
    public void getByPart1() {
        assertThat(LanguageCode.getByPart1("nl").get().getRefName()).isEqualTo("Dutch");
        assertThat(LanguageCode.getByPart1(null)).isEmpty();

    }
    
    @Test
    public void getByPart2T() {
        assertThat(LanguageCode.getByPart2T("nld").get().getRefName()).isEqualTo("Dutch");
        assertThat(LanguageCode.getByPart2T(null)).isEmpty();

    }
    
    @Test
    public void getByPart2B() {
        assertThat(LanguageCode.getByPart2B("dut").get().getRefName()).isEqualTo("Dutch");
        assertThat(LanguageCode.getByPart2B(null)).isEmpty();

    }
    
    @Test
    public void getUnknown() {
        assertThat(LanguageCode.getByCode("doesntexist")).isEmpty();
    }
    
    
    @Test
    public void getCode() {
        assertThat(LanguageCode.getByCode("nld").get().getCode()).isEqualTo("nl");
        assertThat(LanguageCode.getByCode("act").get().getCode()).isEqualTo("act");
    }
    

}