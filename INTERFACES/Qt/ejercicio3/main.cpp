#include <QApplication>
#include <QHBoxLayout>
#include <QSlider>
#include <QSpinBox>
#include <QPushButton>


  int main(int argc, char *argv[])
  {
      QApplication app(argc, argv);

      QWidget *window = new QWidget;
      window->setWindowTitle("Enter Your Age");

     QSpinBox *spinBox = new QSpinBox;
     QSlider *slider = new QSlider(Qt::Horizontal);
     QPushButton *button = new QPushButton("+1");
     QPushButton *button1 = new QPushButton("-1");

     spinBox->setRange(0, 130);
     slider->setRange(0, 130);
     
     

     QObject::connect(spinBox, SIGNAL(valueChanged(int)),
                      slider, SLOT(setValue(int)));
     QObject::connect(slider, SIGNAL(valueChanged(int)),
                      spinBox, SLOT(setValue(int)));
    
      QObject::connect(button, SIGNAL(clicked()),spinBox, SLOT(stepUp()));
      QObject::connect(button1, SIGNAL(clicked()),spinBox, SLOT(stepDown()));

     spinBox->setValue(23);
     QHBoxLayout *layout = new QHBoxLayout;
     layout->addWidget(spinBox);
     layout->addWidget(slider);
     layout->addWidget(button);
      layout->addWidget(button1);
     window->setLayout(layout);

     window->show();

     return app.exec();
 }

