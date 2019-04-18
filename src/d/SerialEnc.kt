package d;
import d._SerialEnc.Core;
/* Java (not compatable yet):
private SerialEnc se= new SerialEnc();
se.append(4192);    //Note:   Places an integer into the buffer, and returns its address.
se.append(2.56);    //Note:   Places a double into the buffer, and returns its address.
se.append("This is a serializer!  ");    //Note:   Places a string into the buffer, and returns its address.
//Note:   You may not need to use se.toString() though, because it may only make things messy.
*/;
/* Kotlin:
private var SerialEnc se= SerialEnc();
se.append(4192);    //Note:   Places an integer into the buffer, and returns its address.
se.append(2.56);    //Note:   Places a double into the buffer, and returns its address.
se.append("This is a serializer!  ");    //Note:   Places a string into the buffer, and returns its address.
//Note:   You may not need to use se.toString() though, because it may only make things messy.
*/;
class SerialEnc {
    var c= Core();
    var i= 0;
    var j= 0;
    var k= 0;
    private var d :ByteArray?= null;
    constructor(Len :Int){
        this.d= ByteArray(Len);
        this.j= Len;
    };
    fun Integer(i :Int?= null) :Int{
        var oP :Int= this.i;
        Core().Bytes_To_Int(this.d!!, i!!);
        this.i +=4;
        return oP;
    };
    fun PshByte(b :Byte){ this.d!![this.i]= b; this.i++; };    //Note:   PshByte is what will allow serialized data to be appended to the data-body.
    fun PshByte(i :Int){
        if(i in 0..255){println("The byte is a value from 0..255, not ${i}.  ");return};
        this.d!![this.i]= i.toByte();
        this.i++;
    };
    fun PopByte() :Int{ this.i--; var v= this.d!![this.i].toInt(); while(v < 0){v +=256}; return v; };    //Note:   PopByte is what will allow the reading of serialized data.
    fun PopByte_Int(j :Int) :Int{
        var v= 0;
        for(i in 0..3){
            v +=this.PopByte() * Math.pow(256.0, i.toDouble()).toInt();
        };
        return v;
    };    //Note:   PopByte is what will allow the reading of serialized data.
    fun Integer() :Int= this.Integer(this.i -4);
    fun Append(d :ByteArray) :Int{ var oP= this.i; for(i in 0..(d.count() -1)){ this.d!![this.i + i]= d[i]; }; this.i +=d.count(); return oP; };
    fun Append(d :CharArray) :Int{ var oP= this.i; for(i in 0..(d.count() -1)){ this.d!![this.i + i]= d[i].toByte(); }; this.i +=d.count() +1; return oP; };
    fun Append(d :String) :Int{ var oP= this.i; for(i in 0..(d.length -1)){ this.d!![this.i + i]= d[i].toByte(); }; this.i +=d.count() +1; return oP; };
    fun Append(v :Int) :Int{
        var a= this.i;
        var d= Core().Int_To_Bytes(v);
        for(i in 0..3){this.PshByte(d.d!![i])};
        return a;
    };
    fun append(v :ByteArray)= this.Append(v);
    fun append(v :CharArray)= this.Append(v);
    fun append(v :String)= this.Append(v);
    fun append(v :Int)= this.Append(v);
    fun Show(){ for(i in 0..(this.j -1)){ if(this.d!![i].toInt()==0){print(" ")}else{print(this.d!![i].toChar())}; }; };
    override fun toString() :String{ var d= StringBuilder(); var Skip= false; for(i in 0..(this.j -1)){
        if(this.d!![i].toInt() in 0..12){Skip= true};
        if(this.d!![i].toInt() in 14..31){Skip= true};
    if(Skip){d.append(" "); Skip= false}else{d.append(this.d!![i].toChar())}; }; return d.toString(); };
};
