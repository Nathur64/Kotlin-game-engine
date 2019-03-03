package Kotlin1;
/**
 * This is a collection of classes and functions that have not been completely tested, and have not yet been categorized yet.  
**/
class Quadruple constructor(first :Any, second :Any, third :Any, forth :Any){
    var first= first;
    var second= second;
    var third= third;
    var forth= forth;
    override open fun toString() :String{ return "($first, $second, $third, $forth)"; };
    open fun copy() :Quadruple= Quadruple(this.first, this.second, this.third, this.forth);
    open fun iadd(o :Quadruple){
        this.first= this.first.toLong() + o.first.toLong();
    };
};
fun gType(Type :Any) :String{
    return when(Type.javaClass){
        Byte.javaClass->   "Byt";
        Char.javaClass->   "Chr";
        Int.javaClass->    "i32";
        Long.javaClass->   "i64";
        String.javaClass-> "Str";
        Unit.javaClass->   "Non";
        else ->            "Any";
    };
};
fun Any.toLong() :Long?{
    return when(gType(this)){
        "Byt"-> this.toLong();
        "Chr"-> this.toLong();
        "i32"-> this.toLong();
        "i64"-> null;
        "Str"-> this.toLong();
        else->  null;
    };
};
class Quaternion(private val a: Double, private val b: Double, private val c: Double, private val d: Double) {
    constructor(r: Double) : this(r, 0.0, 0.0, 0.0) {};
    fun norm(): Double {
        return Math.sqrt(a * a + b * b + c * c + d * d);
    };
    fun negative(): Quaternion {
        return Quaternion(-a, -b, -c, -d);
    };
    fun conjugate(): Quaternion {
        return Quaternion(a, -b, -c, -d);
    };
    fun add(r: Double): Quaternion {
        return Quaternion(a + r, b, c, d);
    };
    fun add(q: Quaternion): Quaternion {
        return Quaternion(a + q.a, b + q.b, c + q.c, d + q.d);
    };
    operator fun times(r: Double): Quaternion {
        return Quaternion(a * r, b * r, c * r, d * r);
    };
    operator fun times(q: Quaternion): Quaternion {
        return Quaternion(
                a * q.a - b * q.b - c * q.c - d * q.d,
                a * q.b + b * q.a + c * q.d - d * q.c,
                a * q.c - b * q.d + c * q.a + d * q.b,
                a * q.d + b * q.c - c * q.b + d * q.a;
        );
    };
    override fun equals(obj: Any?): Boolean {
        if (obj !is Quaternion) return false;
        val other = obj as Quaternion?;
        if (java.lang.Double.doubleToLongBits(this.a) != java.lang.Double.doubleToLongBits(other!!.a)) return false;
        if (java.lang.Double.doubleToLongBits(this.b) != java.lang.Double.doubleToLongBits(other.b)) return false;
        if (java.lang.Double.doubleToLongBits(this.c) != java.lang.Double.doubleToLongBits(other.c)) return false;
        return if (java.lang.Double.doubleToLongBits(this.d) != java.lang.Double.doubleToLongBits(other.d)) false else true;
    };
    override fun toString(): String {
        return String.format("%.2f + %.2fi + %.2fj + %.2fk", a, b, c, d).replace("\\+ -".toRegex(), "- ");
    };
    fun toQuadruple(): String {
        return String.format("(%.2f, %.2f, %.2f, %.2f)", a, b, c, d);
    };
    companion object {
        fun add(q: Quaternion, r: Double): Quaternion {
            return q.add(r);
        };
        fun add(r: Double, q: Quaternion): Quaternion {
            return q.add(r);
        };
        fun add(q1: Quaternion, q2: Quaternion): Quaternion {
            return q1.add(q2);
        };
        fun times(q: Quaternion, r: Double): Quaternion {
            return q.times(r);
        };
        fun times(r: Double, q: Quaternion): Quaternion {
            return q.times(r);
        };
        fun times(q1: Quaternion, q2: Quaternion): Quaternion {
            return q1.times(q2);
        };
        @JvmStatic
        fun main(args: Array<String>) {
            val q = Quaternion(1.0, 2.0, 3.0, 4.0);
            val q1 = Quaternion(2.0, 3.0, 4.0, 5.0);
            val q2 = Quaternion(3.0, 4.0, 5.0, 6.0);
            val r = 7.0;
            System.out.format("q       = %s%n", q);
            System.out.format("q1      = %s%n", q1);
            System.out.format("q2      = %s%n", q2);
            System.out.format("r       = %.2f%n%n", r);
            System.out.format("\u2016q\u2016     = %.2f%n", q.norm());
            System.out.format("-q      = %s%n", q.negative());
            System.out.format("q*      = %s%n", q.conjugate());
            System.out.format("q + r   = %s%n", q.add(r));
            System.out.format("q1 + q2 = %s%n", q1.add(q2));
            System.out.format("q \u00d7 r   = %s%n", q.times(r));
            val q1q2 = q1.times(q2);
            val q2q1 = q2.times(q1);
            System.out.format("q1 \u00d7 q2 = %s%n", q1q2);
            System.out.format("q2 \u00d7 q1 = %s%n", q2q1);
            System.out.format("q1 \u00d7 q2 %s q2 \u00d7 q1%n", if (q1q2 == q2q1) "=" else "\u2260");
        };
    };
};
