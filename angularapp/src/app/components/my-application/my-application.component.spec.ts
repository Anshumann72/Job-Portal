import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MyApplicationComponent } from './my-application.component';
import { HttpClientModule } from '@angular/common/http';
  
describe('MyApplicationComponent', () => {
  let component: MyApplicationComponent;
  let fixture: ComponentFixture<MyApplicationComponent>;
  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
      declarations: [ MyApplicationComponent ]
    }) 
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('Frontend_day33_should_create_MyApplication_Component', () => {
    expect(component).toBeTruthy();
  });
});
