package org.dbflute.handson.dbflute.bsbhv.cursor;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.dbflute.jdbc.CursorHandler;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursor;

/**
 * The cursor handler of PurchaseMonthCursor.
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchaseMonthCursorCursorHandler implements CursorHandler {

    /**
     * Handle the cursor.
     * @param rs The cursor (result set) for the query, which has first pointer. (NotNull)
     * @return The result object of handling process. (NullAllowed)
     * @throws SQLException
     */
    public Object handle(ResultSet rs) throws SQLException {
        return fetchCursor(createTypeSafeCursor(rs));
    }

    /**
     * Create the type-safe cursor.
     * @param rs The cursor (result set) for the query, which has first pointer. (NotNull)
     * @return The created type-safe cursor. (NotNull)
     * @throws SQLException
     */
    protected PurchaseMonthCursorCursor createTypeSafeCursor(ResultSet rs) throws SQLException {
        final PurchaseMonthCursorCursor cursor = new PurchaseMonthCursorCursor();
        cursor.accept(rs);
        return cursor;
    }

    /**
     * Fetch the cursor.
     * @param cursor The type-safe cursor for the query, which has first pointer. (NotNull)
     * @return The result object of handling process. (NullAllowed)
     * @throws SQLException
     */
    protected abstract Object fetchCursor(PurchaseMonthCursorCursor cursor) throws SQLException;
}
