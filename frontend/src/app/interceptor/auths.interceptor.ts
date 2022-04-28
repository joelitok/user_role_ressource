import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";

export class AuthInterceptor implements HttpInterceptor{

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = sessionStorage.getItem('token') != null ? 'Bearer ' + String(sessionStorage.getItem('token')) : '';
        const newReq = req.clone(
            {
                headers: req.headers.set('Authorization', token)
            }
        );
        //console.dir(newReq);
        return next.handle(newReq);
    }

}
