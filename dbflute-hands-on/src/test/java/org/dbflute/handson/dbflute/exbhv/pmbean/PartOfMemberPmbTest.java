package org.dbflute.handson.dbflute.exbhv.pmbean;

import org.dbflute.handson.unit.UnitContainerTestCase;

/**
 * @author mayuko.sakaba
 */
public class PartOfMemberPmbTest extends UnitContainerTestCase {

    public void test_existsServicePointCountFalse() throws Exception {
        PartOfMemberPmb pmb = new PartOfMemberPmb() {
            @Override
            public boolean isPaging() {
                return false;
            }
        };
        assertTrue(pmb.isPaging());
        pmb.setServicePointCount(3);
        assertFalse(pmb.isPaging());
    }

    public void test_existsServicePointCountTrue() throws Exception {
        PartOfMemberPmb pmb = new PartOfMemberPmb() {
            @Override
            public boolean isPaging() {
                return true;
            }
        };
        assertTrue(pmb.isPaging());
        pmb.setServicePointCount(3);
        assertTrue(pmb.isPaging());
    }
}
