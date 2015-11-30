package org.stellar.base;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Base class for AssetTypeCreditAlphaNum4 and AssetTypeCreditAlphaNum12 subclasses.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/assets.html" target="_blank">Assets</a>
 */
public abstract class AssetTypeCreditAlphaNum extends Asset {
    protected final String mCode;
    protected final Keypair mIssuer;

    public AssetTypeCreditAlphaNum(String code, Keypair issuer) {
        mCode = checkNotNull(code, "code cannot be null");
        mIssuer = checkNotNull(issuer, "issuer cannot be null");
    }

    /**
     * Returns asset code
     */
    public String getCode() {
        return mCode;
    }

    /**
     * Returns asset issuer
     */
    public Keypair getIssuer() {
        return mIssuer;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }

        AssetTypeCreditAlphaNum o = (AssetTypeCreditAlphaNum) object;

        return this.getCode().equals(o.getCode()) &&
                this.getIssuer().getAddress().equals(o.getIssuer().getAddress());
    }
}
