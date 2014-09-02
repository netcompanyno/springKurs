package no.mesan.utils;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Test {@link Sjekksum}.
 */
@RunWith(Parameterized.class)
public class SjekksumTest {

    enum TestType {
        GodPerson,
        FeilPerson,
        GodOrg,
        FeilOrg
    }

    private final TestType testType;
    private final String kundeNr;
    private final String kundeNavn;

    @Parameters
    public static Collection<Object[]> config() {
        return Arrays.asList(new Object[][] {
            { "Buster Minal",  "14037243710",  TestType.GodPerson },
            { "Tine Melch",  "12073210664",  TestType.GodPerson },
            { "Tom Bola",  "17050355543",  TestType.GodPerson },
            { "Ane Mi",  "18089961471",  TestType.GodPerson },
            { "Kåre Dump",  "30129831096",  TestType.GodPerson },
            { "Anna Nass",  "24128025489",  TestType.FeilPerson },
            { "Tove Is",  "24128025631",  TestType.FeilPerson },
            { "Andre Veien",  "1404721355",  TestType.FeilPerson },
            { "John Gelbocken",  "67078701541",  TestType.GodPerson },
            { "Tomm Hendt",  "5114304788",  TestType.FeilPerson },
            { "Mina Reten",  "12345678901234567890",  TestType.FeilPerson },
            { "NSB",  "984661177",  TestType.GodOrg },
            { "BSN",  "984661175",  TestType.FeilOrg },
            { "ABC",  "959810990",  TestType.GodOrg },
            { "AB",  "9598109",  TestType.FeilOrg },
            { "ABCDE",  "95981099012",  TestType.FeilOrg }
        });
    }

    public SjekksumTest(final String name, final String knr, final TestType tType) {
        this.kundeNavn= name;
        this.kundeNr= knr;
        this.testType= tType;
    }

    @Test
    public void runTest() {
        switch ( this.testType ) {
            case GodPerson: assertTrue(this.kundeNavn, Sjekksum.gyldigFnr(this.kundeNr)); break;
            case FeilPerson: assertFalse(this.kundeNavn, Sjekksum.gyldigFnr(this.kundeNr)); break;
            case GodOrg: assertTrue(this.kundeNavn, Sjekksum.gyldigOrgnr(this.kundeNr)); break;
            case FeilOrg: assertFalse(this.kundeNavn, Sjekksum.gyldigOrgnr(this.kundeNr)); break;
        }
    }
}
