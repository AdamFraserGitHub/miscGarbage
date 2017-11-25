int pos = 0;
void setup() {
  size(800,800);
  background(0);
  frameRate(60);
}

void draw() {
  checkPos();
  for(int i = 0; i < 10; i++){
    point(random(1/7f * width) + (pos/7f) * width , mouseY + (random(100) - 50));
  }
}

void checkPos() {
  if(mouseX > 0 && mouseX < (1/7f) * 800){
    stroke(255,0,0);
    pos = 0;
  }
  if(mouseX > (1/7f) * 800 && mouseX < (2/7f) * 800){
    stroke(255,150,0);
    pos = 1;
  }
  if(mouseX > (2/7f) * 800 && mouseX < (3/7f) * 800){
    stroke(255,255,0);
    pos = 2;
  }
  if(mouseX > (3/7f) * 800 && mouseX < (4/7f) * 800){
    stroke(0,255,0);
    pos = 3;
  }
  if(mouseX > (4/7f) * 800 && mouseX < (5/7f) * 800){
    stroke(0,150,255);
    pos = 4;
  }
  if(mouseX > (5/7f) * 800 && mouseX < (6/7f) * 800){
    stroke(0,0,255);
    pos = 5;
  }
  if(mouseX > (6/7f) * 800 && mouseX < 800){
    stroke(150,0,255);
    pos = 6;
  }
}