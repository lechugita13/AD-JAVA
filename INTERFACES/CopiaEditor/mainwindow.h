#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QChartView>
#include <QLineSeries>
#include <QChart>
#include <QValueAxis>
#include <QLabel>


QT_CHARTS_USE_NAMESPACE

class MainWindow : public QMainWindow {
Q_OBJECT
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
        //crearMenus();
        QChart *chart;
        QChartView *chartView;
        QLineSeries *serie;     

public slots:

        void slotResaltar(const QPointF &,bool);
        void slotTemporizador();

};
#endif 
