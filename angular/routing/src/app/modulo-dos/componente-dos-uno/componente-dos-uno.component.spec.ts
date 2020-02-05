import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteDosUnoComponent } from './componente-dos-uno.component';

describe('ComponenteDosUnoComponent', () => {
  let component: ComponenteDosUnoComponent;
  let fixture: ComponentFixture<ComponenteDosUnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteDosUnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteDosUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
