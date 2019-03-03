package Kotlin1;
class Quadruple constructor(first :Any, second :Any, third :Any, forth :Any){
    var first= first;
    var second= second;
    var third= third;
    var forth= forth;
    override open fun toString() :String{ return "($first, $second, $third, $forth)"; };
    open fun copy() :Quadruple= Quadruple(this.first, this.second, this.third, this.forth);
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
