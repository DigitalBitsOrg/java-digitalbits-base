package io.digitalbits.base;

import io.digitalbits.base.xdr.OperationType;

/**
 * Represents <a href="https://developer.digitalbits.io/guides/concepts/list-of-operations.html#inflation" target="_blank">Inflation</a> operation.
 * @see <a href="https://developer.digitalbits.io/guides/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class InflationOperation extends Operation {
    @Override
    io.digitalbits.base.xdr.Operation.OperationBody toOperationBody() {
        io.digitalbits.base.xdr.Operation.OperationBody body = new io.digitalbits.base.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.INFLATION);
        return body;
    }
}
