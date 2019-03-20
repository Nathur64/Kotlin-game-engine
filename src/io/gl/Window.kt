package io.gl;
import org.lwjgl.glfw.GLFW;
class Window {
    private var width :Int= 0;
    private var height :Int= 0;
    private var title :String= "";
    private var window :Long= 0;
    constructor(width :Int, height :Int, title :String){
        this.width= width;
        this.height= height;
        this.title= title;
    };
    fun create(){
        this.width= width;
        this.height= height;
        this.title= title;
        if(!GLFW.glfwInit()) System.exit(1);
        this.window= GLFW.glfwCreateWindow(this.width, this.height, this.title, 0, 0);
        if(this.window==0L) System.exit(2);
        var videoMode= GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(this.window, (videoMode!!.width() - this.width) /2, (videoMode.height() - this.height) /2);
        GLFW.glfwShowWindow(this.window);
    };
    fun closed() :Boolean= GLFW.glfwWindowShouldClose(this.window);
    fun update() {GLFW.glfwPollEvents()};
    fun swapBuffers() {GLFW.glfwSwapBuffers(this.window)};
};
