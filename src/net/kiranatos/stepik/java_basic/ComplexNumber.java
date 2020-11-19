package net.kiranatos.stepik.java_basic;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(re+im);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ComplexNumber other = (ComplexNumber) obj;
        
        if (Double.doubleToLongBits(this.re) != Double.doubleToLongBits(other.re)) {
            return false;
        }
        if (Double.doubleToLongBits(this.im) != Double.doubleToLongBits(other.im)) {
            return false;
        }
        
        return true;
    }
    
    
}