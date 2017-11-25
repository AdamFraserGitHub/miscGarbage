float yRot = 0;
float xRot = 0;
float zoom = 1;

void setup() {
 fullScreen(P3D);
 background(0);
}

void draw() {
  
  if(keyPressed){
    if(key == 'w'){
      xRot ++;  
    }
    if(key == 'a'){
      yRot --;
    }
    if(key == 's'){
      xRot --;
    }
    if(key == 'd'){
      yRot ++;
    }
  }
  noFill();
  clear();
  translate(width/2, height/2);
  //frameCount = 0;
  stroke(255, 0, 0);
  pushMatrix();
    rotateY(radians(frameCount*1/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(100 * zoom);
  popMatrix();
  
  stroke(255, 150, 0);
  pushMatrix();
    rotateY(radians(frameCount*2/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(120 * zoom);
  popMatrix();
  
  stroke(255, 255, 0);
  pushMatrix();
    rotateY(radians(frameCount*3/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(140 * zoom);
  popMatrix();
  
  stroke(0, 255, 0);
  pushMatrix();
    rotateY(radians(frameCount*4/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(160 * zoom);
  popMatrix();
  
  stroke(0, 250, 255);
  pushMatrix();
    rotateY(radians(frameCount*5/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(180 * zoom);
  popMatrix();
  
  stroke(0, 0, 255);
  pushMatrix();
    rotateY(radians(frameCount*6/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(200 * zoom);
  popMatrix();
  
  stroke(200, 0, 255);
  pushMatrix();
    rotateY(radians(frameCount*7/10 + yRot));
    rotateX(radians(xRot));
    sphereDetail(10);
    sphere(220 * zoom);
  popMatrix();
}

void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  
  if(e < 0) {
    zoom+=0.01;
  } else if(e > 0) {
    zoom -= 0.01 * zoom * zoom;
  }
}

void keyPressed() {
  
}